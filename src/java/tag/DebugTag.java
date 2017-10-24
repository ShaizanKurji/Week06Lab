package tag;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 715060
 */
public class DebugTag extends TagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    public int doTag() throws JspException {
        HttpServletRequest sRequest = (HttpServletRequest) pageContext.getRequest();
        boolean debugExists = false;
        boolean validDomain = false;
        String domainQuery;

        domainQuery = sRequest.getQueryString();
        if (domainQuery != null) {
            Pattern pt = Pattern.compile("\\bdebug\\b");
            Matcher mt = pt.matcher(domainQuery);
            debugExists = mt.find();
        }

        domainQuery = sRequest.getServerName();
        if (domainQuery != null) {
            if (domainQuery.contains("test") || domainQuery.contains("localhost")) {
                validDomain = true;
            }
        }
        if (debugExists && validDomain) {
            return EVAL_BODY_INCLUDE;
        } else {
            return SKIP_BODY;
        }

    }

}
