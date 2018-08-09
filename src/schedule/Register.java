package schedule;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String input_name = request.getParameter("name");
		String input_id = request.getParameter("id");
		String input_pass = request.getParameter("pass");

		User login_user = new User(input_id, input_pass, input_name);

		response.setContentType("text/html; charset=UTF-8");

		Connection conn = null;

		try {
			// JDBCドライバを読み込み
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// データベースへ接続
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.132:1521:xe", "stockuser", "moriara0029");

			// SQLを実行し、登録されている名前、パスワードを取得
			String sql = "select * from users";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// selectを実行し、結果票を取得
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String db_exist_id = rs.getString("ID");
				String db_exist_pass = rs.getString("PASS");
				String db_exist_name = rs.getString("NAME");
				
				//名前が一致するか
				if (db_exist_name.equals(input_name)) {
					
					System.out.println("名前一致してもうてるやん!");
				

					// user名が一致するか
					if (db_exist_id.equals(input_id)) {
						System.out.println("ID一致してるやん！");

						// パスワードが一致するか
						if (db_exist_pass.equals(input_pass)) {
							System.out.println("パスも一致してるやん！");

							// すでに登録されている場合はセッションスコープをnullのままに
							break;

						}

					}
				}

				// DBに未登録の時の処理
				// ユーザー情報をDBに登録
				// 登録に成功したかの判定に使うためlogin_userインスタンスをセッションスコープに保存
				sql = "insert into users values ('" + login_user.getName() + "','" + login_user.getPass() + "',"
						+ login_user.getId() + ")";

				int num = pstmt.executeUpdate(sql);

				HttpSession session = request.getSession();
				session.setAttribute("loginUser", login_user);

			}

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
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/RegisterResult.jsp");
		dispacher.forward(request, response);

	}
}