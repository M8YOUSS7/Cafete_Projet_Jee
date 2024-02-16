package com.yyouss.filter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class HeaderFooterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation du filtre
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Code pour ajouter l'en-tête avant la requête
        request.getRequestDispatcher("/WEB-INF/header.jsp").include(request, response);

        // Laisser la requête suivre son cours
        chain.doFilter(request, response);

        // Code pour ajouter le pied de page après la requête
        request.getRequestDispatcher("/WEB-INF/footer.jsp").include(request, response);
    }

    @Override
    public void destroy() {
        // Nettoyage lors de la destruction du filtre
    }
}
