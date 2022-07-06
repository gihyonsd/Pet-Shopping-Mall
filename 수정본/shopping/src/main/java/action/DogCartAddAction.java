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
			int id = Integer.parseInt(request.getParameter("id")); //장바구니에 추가될 상품의 아이디를 파라미터로 얻어옴
			Dog cartDog = dogCartAddService.getCartDog(id); //장바구니 항목에 추가 될 상품 정보를 얻어오는 부분
			dogCartAddService.addCart(request, cartDog); //특정 상품을 장바구니 항목으로 ㅊ푸가하는 메소드를 호출하는 부분 세션 영역 객체에 장바구니 항목을 추가해야 하기 때문에 파라미터 값으로 request 객체를 던진다.
			ActionForward forward = new ActionForward("dogCartList.dog", true);
			return forward;
		}
	}


