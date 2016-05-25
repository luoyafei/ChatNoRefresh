package com.chat.service;

import java.util.List;

import com.chat.Factory.DaoFactory;
import com.chat.Factory.ServiceFactory;
import com.chat.bean.HeadPicture;
import com.chat.interfacedao.HeadPictureDao;
import com.chat.interfaceservice.HeadPictureService;

public class HeadPictureMysqlService implements HeadPictureService {

	private HeadPictureDao hpd = null;

	public HeadPictureMysqlService() {
		hpd = DaoFactory.createHeadPictureDao();
	}
	
	@Override
	public boolean insertHeadPicture(HeadPicture picture) {
		// TODO Auto-generated method stub
		return hpd.insertHeadPicture(picture);
	}

	@Override
	public boolean updateHeadPicture(HeadPicture picture) {
		// TODO Auto-generated method stub
		return hpd.updateHeadPicture(picture);
	}

	@Override
	public boolean deleteHeadPicture(Integer pictureId) {
		// TODO Auto-generated method stub
		return hpd.deleteHeadPicture(pictureId);
	}

	@Override
	public HeadPicture getHeadPictureInId(Integer pictureId) {
		// TODO Auto-generated method stub
		return hpd.getHeadPictureInId(pictureId);
	}

	@Override
	public List<HeadPicture> getAllHeadPicture() {
		// TODO Auto-generated method stub
		return hpd.getAllHeadPicture();
	}
	
	

}
