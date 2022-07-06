package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.DogCartAddService;
import vo.ActionForward;
import vo.Dog;

public class DogCartAddAction implements Action{
		
		@Override
		public ActionForward execute(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			DogCartAddService dogCartAddService = new DogCartAddService();
			int id = Integer.parseInt(request.getParameter("id")); //��ٱ��Ͽ� �߰��� ��ǰ�� ���̵� �Ķ���ͷ� ����
			Dog cartDog = dogCartAddService.getCartDog(id); //��ٱ��� �׸� �߰� �� ��ǰ ������ ������ �κ�
			dogCartAddService.addCart(request, cartDog); //Ư�� ��ǰ�� ��ٱ��� �׸����� ��Ǫ���ϴ� �޼ҵ带 ȣ���ϴ� �κ� ���� ���� ��ü�� ��ٱ��� �׸��� �߰��ؾ� �ϱ� ������ �Ķ���� ������ request ��ü�� ������.
			ActionForward forward = new ActionForward("dogCartList.dog", true);
			return forward;
		}
	}


