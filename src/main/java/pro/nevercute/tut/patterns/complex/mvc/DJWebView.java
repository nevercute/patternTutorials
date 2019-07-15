package pro.nevercute.tut.patterns.complex.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DJWebView extends HttpServlet {
    public void init() throws ServletException {
        BeatModel beatModel = new BeatModelImpl();
        beatModel.init();
        getServletContext().setAttribute("beatModel", beatModel);
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BeatModel beatModel = (BeatModel) getServletContext().getAttribute("beatModel");

        String bpm = request.getParameter("bpm");
        if(bpm == null){
            bpm = beatModel.getBPM()+"";
        }

        String set = request.getParameter("set");
        if(set != null){
            int bpmNumber = 90;
            bpmNumber = Integer.parseInt(bpm);
            beatModel.setBPM(bpmNumber);
        }

        String decrease = request.getParameter("decrease");
        if(decrease != null){
            beatModel.setBPM(beatModel.getBPM() -1);
        }

        String increase = request.getParameter("increase");
        if(increase != null){
            beatModel.setBPM(beatModel.getBPM() + 1);
        }

        String on = request.getParameter("on");
        if(on != null){
            beatModel.on();
        }

        String off = request.getParameter("off");
        if(off != null){
            beatModel.off();
        }

        request.setAttribute("beatModel", beatModel);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/DJView.jsp");
        dispatcher.forward(request, response);
    }

}
