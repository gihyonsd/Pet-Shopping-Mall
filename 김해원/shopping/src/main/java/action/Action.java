package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;

/*�׼� ���� Ŭ������ Action�������̽��� �����ϰ� �����ν� ��û
 * ActionForwardŬ������ ������ ���� �����͸� �����ϰ� ActionForward��ü�� �����ϰ� ó��*/
public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}