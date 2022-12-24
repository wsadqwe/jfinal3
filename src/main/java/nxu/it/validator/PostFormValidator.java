package nxu.it.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class PostFormValidator extends Validator {
    private String errorKey = "message";
    @Override
    protected void validate(Controller controller) {
        setShortCircuit(true);
        validateRequiredString("title", errorKey, "文章标题为空");
        validateRequired("category_id", errorKey, "文章分类为空");
        validateRequiredString("content", errorKey, "文章内容为空");
    }

    @Override
    protected void handleError(Controller controller) {
        controller.renderFreeMarker("error.ftl");
    }
}
