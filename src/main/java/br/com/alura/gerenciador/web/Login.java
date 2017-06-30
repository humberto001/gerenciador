package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet (urlPatterns= "/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	PrintWriter writer = resp.getWriter();
		
	String email = req.getParameter("email");
	String senha = req.getParameter("senha");
	
	Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email,senha);
	
	if(usuario==null){
		writer.println("<html><body>Usuário ou senha inválida</body></html>");
	}else{
		Cookie cookie = new Cookie("usuario.logado", email);
		resp.addCookie(cookie);
		writer.println("<html><body>Usuário logado: "+ email+"</body></email>");
	}
	
	}

}
