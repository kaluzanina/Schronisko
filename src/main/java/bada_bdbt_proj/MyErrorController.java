package bada_bdbt_proj;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


import org.springframework.ui.Model;

@Controller
public class MyErrorController implements ErrorController {
    private final AuthenticationUtil authenticationUtil;

    public MyErrorController(AuthenticationUtil authenticationUtil) {
        this.authenticationUtil = authenticationUtil;
    }

    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        UserAttributes attributes = authenticationUtil.getUserAttributes();
        model.addAttribute("username", attributes.getUsername());
        model.addAttribute("role", attributes.getRole());
        model.addAttribute("id", attributes.getId());
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "errors/403";
            } else if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "errors/404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "errors/500";
            } else if (statusCode == HttpStatus.GATEWAY_TIMEOUT.value()) {
                return "errors/504";
            } else {
                return "errors/other";
            }
        }

        // Default error view for unexpected cases
        return "errors/other";
    }

    // Optionally, override the method to define the error path
    /*@Override
    public String getErrorPath() {
        return "/error";
    }*/
}
