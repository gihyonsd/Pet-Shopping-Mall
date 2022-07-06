package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;
import svc.DogDeleteService;
public class DogDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		DogDeleteService dogDeleteService = new DogDeleteService();		
		boolean result = dogDeleteService.deletePro(id);
		ActionForward forward = new ActionForward("dogList.dog", false);
		if(result) {
			forward.setRedirect(true);
			forward.setPath("dogList.dog");
		}
		
		return forward;
		
	}

}
