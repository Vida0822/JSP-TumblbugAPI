package project.command;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.dao.FileDAO;
import file.model.File;
import jdbc.connection.ConnectionProvider;
import mvc.command.CommandHandler;
import project.dao.GiftDAO;
import project.dao.ItemSetDAO;
import project.dao.ProjectDAO;
import project.model.Gift;
import project.model.ItemSet;
import project.model.Project;
import project.service.GiftCard;
import project.service.ListProjectService;
import project.service.ProjectCard;
import project.service.ViewCreator;
import project.service.ViewInfo;
import project.service.ViewPlan;
import project.service.ViewProjectService;




public class ViewHandler implements CommandHandler {
	
	private static String FORM_VIEW = "/WEB-INF/view/view.jsp";
	private ViewProjectService viewProjectService = new ViewProjectService();
	private ProjectDAO projectDao = new ProjectDAO();
	private GiftDAO giftDao = new GiftDAO(); 
	private FileDAO fileDAO = new FileDAO(); 
	private ItemSetDAO itemSetDAO = new ItemSetDAO(); 
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			Map<String, Boolean> errors = new HashMap<>();
			request.setAttribute("errors", errors);
			
			String pro_cd = request.getParameter("pro_cd") ; 
		
	
			try (Connection conn = ConnectionProvider.getConnection()) {
				
				Project project = projectDao.selectByCd(conn, pro_cd) ; 	// 프로젝트 객체 얻어와서 
				
				ViewInfo viewInfo = viewProjectService.getViewInfo(conn, project) ;  // 해당 프로젝트 객체로 얻을 수 있는 출력 section 1 관련 정보 
				ArrayList<File> imageFiles =   fileDAO.selectAllByPro_cd(conn, project.getPro_cd()); 
				ViewPlan viewPlan = viewProjectService.getViewPlan(conn, project) ; 
		 		ViewCreator viewCreator = viewProjectService.getViewCreator(conn, project) ; 
				
				
				ArrayList<Gift> giftList = giftDao.selectList(conn , project);
				ArrayList<GiftCard> giftCards = viewProjectService.getGiftCard(conn, giftList) ; 
				
				request.setAttribute("viewInfo", viewInfo);
				request.setAttribute("imageFiles", imageFiles);
				request.setAttribute("viewPlan", viewPlan);
				request.setAttribute("viewCreator", viewCreator);
				request.setAttribute("giftCards", giftCards); 
				request.setAttribute("pro_cd", pro_cd);
								 
				return FORM_VIEW; 
				
			}catch (Exception e) {
				System.out.println("> ViewHandler() processSubmit() Exception...");
				e.printStackTrace();
				return null;
			} // try 
		}// processSubmit
	} //  ViewHandler
