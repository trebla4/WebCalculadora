package UMG;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculadora
 */
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double resultado;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculadora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables que reciben lo que se escribio de la pagina
		double resultado = 0;
		String stringValor = request.getParameter("valor");
		String stringResultado = request.getParameter("resultado");
		

		if (!stringValor.isEmpty()) {

			double valor = Double.parseDouble(stringValor);
			
			//Obtenemos los parametros de los botones del JSP
			Map param = request.getParameterMap();
			
			if (param.containsKey("suma")) {
				resultado += valor;
			} else if (param.containsKey("resta")) {
				resultado -= valor;
			} else if (param.containsKey("division")) {
				resultado /= valor;
			} else if (param.containsKey("multiplicacion")) {
				resultado *= valor;
			}else if (param.containsKey("borrar")) {
				resultado=0;
				resultado += 0;
			}
			
			//Ajustamos el campo del resultado al resultado de la operacion
			request.setAttribute("valor", resultado);

			RequestDispatcher view = request.getRequestDispatcher("/Calc.jsp");
			view.forward(request, response);

		}else {

			RequestDispatcher view = request.getRequestDispatcher("/Calc.jsp");
			view.forward(request, response);

		}
		
		//Validacion de campos vacios y se pone 0 como res en caso de saltarse validacion
				if (!stringResultado.isEmpty()) {
					resultado = Double.parseDouble(stringResultado);
				}
		
	}

}
