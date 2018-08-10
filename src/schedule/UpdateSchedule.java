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

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import model.User;
import model.UserSchedule;

@WebServlet("/UpdateSchedule")
public class UpdateSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// リクエストパラメータから値を取得
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		String schedule = request.getParameter("schedule");
		
		System.out.println("入力された日付けは" + date);
		System.out.println("入力された予定は" + schedule);

		response.setContentType("text/html; charset=UTF-8");

		Connection conn = null;

		try {
			// JDBCドライバを読み込み
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// データベースへ接続
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.132:1521:xe", "stockuser", "moriara0029");

			// SQLを実行し、指定された時間のスケジュールを更新
			Statement stmt = conn.createStatement();
			String sql = "update schedule set schedule = '" + schedule + "' where EXPIREDATE = to_date('" + date
					+ "','YYYY-MM-DD HH24:MI:SS')";
			System.out.println("実行するSQLは" + sql);
			int num = stmt.executeUpdate(sql);
			System.out.println("実行かんりょ");

			// ユーザーのスケジュール表示画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UpdateSchedule.jsp");
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