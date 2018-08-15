package manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/ManageLogin")
public class ManageLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String input_id = request.getParameter("id");
		String input_pass = request.getParameter("pass");

		response.setContentType("text/html; charset=UTF-8");

		// IDとパス判定
		if (input_id.equals("1234")) {

			if (input_pass.equals("haitensai")) {

				User login_user = new User(input_id, input_pass);
				HttpSession session = request.getSession();
				session.setAttribute("loginManager", login_user);

			}
		}

		// ログイン結果画面にフォワード
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/ManageLoginResult.jsp");
		dispacher.forward(request, response);

	}
}