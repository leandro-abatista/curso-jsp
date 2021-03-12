package tagPersonalizada;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagCursoJsp extends SimpleTagSupport {
	
	/**
	 * Sobescrevendo a tag -> doTag
	 */
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter saida = getJspContext().getOut();
		saida.println("Tag JSP customizada!!!!!!!!!");
	}

}
