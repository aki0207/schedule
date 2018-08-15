package schedule;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import model.Execution;
import model.User;
import model.UserSchedule;

@WebServlet("/AddSchedule")
public class AddSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// リクエストパラメータから値を取得
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		String schedule = request.getParameter("schedule");

		// insertする際に必要になるため名前とidをセッションスコープから取得
		HttpSession session = request.getSession();
		User login_user = (User) session.getAttribute("loginUser");
		String name = login_user.getName();
		String id = login_user.getId();

		System.out.println("入力された日付けは" + date);
		System.out.println("入力された予定は" + schedule);

		response.setContentType("text/html; charset=UTF-8");

		Connection conn = null;

		try {
			// JDBCドライバを読み込み
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// データベースへ接続
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.132:1521:xe", "stockuser", "moriara0029");

			// selectを実行し、入力した時間の予定が存在するか確認
			Statement stmt = conn.createStatement();
			System.out.println("select文実行するぜい");
			String sql = "select * from schedule where EXPIREDATE = to_date('" + date
					+ "','YYYY-MM-DD HH24:MI:SS')and id = " + id;
			ResultSet rs = stmt.executeQuery(sql);

			
			// 存在しない場合のみ追加する
			if (!(rs.isBeforeFirst())) {
				
				// SQLを実行し、指定された時間にスケジュールを追加
				stmt = conn.createStatement();
				sql = "insert into schedule (ID,SCHEDULE,EXPIREDATE,NAME) values (" + id + ",'" + schedule + "',"
						+ "to_date('" + date + "','YYYY-MM-DD HH24:MI:SS'),'" + name + "')";
				System.out.println("実行するSQLは" + sql);
				int num = stmt.executeUpdate(sql);
				System.out.println("実行かんりょ");
				
				//処理が行われたかの判定に用いるexecutionインスタンスを生成、スコープに保存
				Execution execution_sql = new Execution();
				System.out.println("ちなみにexecution_sqlの中身これな→" + execution_sql);
				session.setAttribute("executionsql", execution_sql);
			}

			// ユーザーのスケジュール表示画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AddScheduleResult.jsp");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (conn != null) {

					conn.close();

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}
}