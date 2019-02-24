package foo;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TestJsp extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //设置属性
        String name=request.getParameter("name");
        request.setAttribute("name",name);
        String pref=request.getParameter("pref");
        request.setAttribute("pref",pref);
        String[]musicList1={"zero7","Tahiti 80","BT","Frou Frou"};
        String[]musicList2={"Matrix","Kill Bill","Boondock Saints"};
        ArrayList musicList=new ArrayList();
        musicList.add(musicList1);
        musicList.add(musicList2);
        request.setAttribute("musicList",musicList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/basicJsp.jsp");
        dispatcher.forward(request,response);
    }

}
