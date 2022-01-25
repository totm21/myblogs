package Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping(value="/page")
@Controller
public class SkipController {
	
	@RequestMapping(value = "/{pageName1}/{pageName2}.action", method = RequestMethod.GET)
    public ModelAndView toPage(@PathVariable("pageName1") String pageName1,@PathVariable("pageName2") String pageName2) {
    	ModelAndView mv = new ModelAndView(pageName1+"/"+pageName2);
    	return mv;
    }

	 @RequestMapping(value = "/{pageName1}.action", method = RequestMethod.GET)
	    public ModelAndView toPage(@PathVariable("pageName1") String pageName1,Model model) {
	        ModelAndView mv = new ModelAndView(pageName1);
	        model.addAttribute("LOG_IN","LOG IN");
	        return mv;
	    }


}
