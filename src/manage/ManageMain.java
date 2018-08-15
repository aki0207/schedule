package manage;

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

@WebServlet("/ManageMain")
public class ManageMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// DBから取得したユーザー情報の入れ物
		ArrayList<String> name = new ArrayList<>();
		HttpSession session = request.getSession();

		Connection conn = null;

		try {
			// JDBCドライバを読み込み
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// データベースへ接続
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.132:1521:xe", "stockuser", "moriara0029");

			// SQLを実行し、登録されている名前、パスワードを取得
			String sql = "select * from users";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// select文を実行し、結果票を取得
			ResultSet rs = pstmt.executeQuery();

			// 検索結果があるなら
			if (rs.isBeforeFirst()) {

				// SQL実行結果を配列に追加していく
				while (rs.next()) {

					name.add(rs.getString("NAME"));

				}

				UserSchedule user_name_list = new UserSchedule(name);

				// ユーザー名をセッションスコープに保存
				
				session.setAttribute("userNameList", user_name_list);

			} else {

				System.out.println("ユーザーいないんじゃね");
				// セッションに残っている消す前のユーザー情報を保持したインスタンスを削除
				session.removeAttribute("userNameList");

			}

			// ユーザーのスケジュール表示画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ManageUserList.jsp");
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