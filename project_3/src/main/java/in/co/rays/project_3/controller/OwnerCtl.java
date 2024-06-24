package in.co.rays.project_3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.OwnerDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.OwnerModelInt;
import in.co.rays.project_3.model.SalaryModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(name = "OwnerCtl", urlPatterns = { "/ctl/OwnerCtl" })

public class OwnerCtl extends BaseCtl{
	
	
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "name"));
			pass = false;
		}

		else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", "name must contains alphabets only");
			System.out.println(pass);
			pass = false;

		}
			

		if (DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", " dob"));

			pass = false;
		} else if (!DataValidator.isDate(request.getParameter("dob"))) {
			request.setAttribute("dob", " dob must contains Date only");
			System.out.println(pass);
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("insurenceAmount"))) {
			request.setAttribute("insurenceAmount", PropertyReader.getValue("error.require", "insurenceAmount"));
			pass = false;
		}

		else if (!DataValidator.isInteger(request.getParameter("insurenceAmount"))) {
			request.setAttribute("insurenceAmount", "InsurenceAmount must contains digit only");
			System.out.println(pass);
			pass = false;

		}		  
		
		if (DataValidator.isNull(request.getParameter("vehicleId"))) {
			request.setAttribute("vehicleId", PropertyReader.getValue("error.require", "vehicleId"));
			pass = false;
		}

		else if (!DataValidator.isInteger(request.getParameter("vehicleId"))) {
			request.setAttribute("vehicleId", "vehicleId must contains digit only");
			System.out.println(pass);
			pass = false;

		}		  

		 

		return pass;

	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		OwnerDTO dto = new OwnerDTO();


		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setName(DataUtility.getString(request.getParameter("name")));
		dto.setInsuranceAmount(DataUtility.getInt(request.getParameter("insurenceAmount")));
		dto.setVehicleId(DataUtility.getInt(request.getParameter("vehicleId")));

        dto.setDob(DataUtility.getDate(request.getParameter("dob")));



		populateBean(dto, request);

		return dto;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = DataUtility.getString(request.getParameter("operation"));
		OwnerModelInt model = ModelFactory.getInstance().getOwnerModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {
			OwnerDTO dto;
			try {
				dto = model.findByPK(id);
				ServletUtility.setDto(dto, request);
			} catch (Exception e) {
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = DataUtility.getString(request.getParameter("operation"));
		OwnerModelInt model = ModelFactory.getInstance().getOwnerModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			OwnerDTO dto = (OwnerDTO) populateDTO(request);
			try {
				if (id > 0) {
					model.update(dto);

					ServletUtility.setSuccessMessage("Data is successfully Update", request);
				} else {

					try {
						model.add(dto);
						ServletUtility.setDto(dto, request);
						ServletUtility.setSuccessMessage("Data is successfully saved", request);
					} catch (ApplicationException e) {
						ServletUtility.handleException(e, request, response);
						return;
					} catch (DuplicateRecordException e) {
						ServletUtility.setDto(dto, request);
						ServletUtility.setErrorMessage("Login id already exists", request);
					}

				}
				ServletUtility.setDto(dto, request);

			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Login id already exists", request);
			}
		} else if (OP_DELETE.equalsIgnoreCase(op)) {

			OwnerDTO dto = (OwnerDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.OWNER_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.OWNER_LIST_CTL, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.OWNER_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.OWNER_VIEW;
	}



}
