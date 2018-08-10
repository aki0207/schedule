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

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User login_user = (User) session.getAttribute("loginUser");
		Connection conn = null;
		
		//DBから取得したスケジュール情報の入れ物
		ArrayList<String> id = new ArrayList<>();
		ArrayList<String> schedule = new ArrayList<>();
		ArrayList<String> date = new ArrayList<>();
		ArrayList<String> name = new ArrayList<>();

		try {
			// JDBCドライバを読み込み
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// データベースへ接続
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.132:1521:xe", "stockuser", "moriara0029");

			// SQLを実行し、登録されている名前、パスワードを取得
			String sql = "select * from schedule where id = " + login_user.getId() + "order by expiredate";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// selectを実行し、結果票を取得
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				id.add (rs.getString("ID"));
				schedule.add (rs.getString("SCHEDULE"));
				date.add (rs.getString("EXPIREDATE"));
				name.add (rs.getString("NAME"));

			}

			UserSchedule user_schedule = new UserSchedule(id, schedule, date, name);

			// ユーザー情報をセッションスコープに保存
			session.setAttribute("user_schedule", user_schedule);

			// ユーザーのスケジュール表示画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserSchedule.jsp");
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

		// ログイン結果画面にフォワード
//		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/LoginResult.jsp");
//		dispacher.forward(request, response);

	}
}