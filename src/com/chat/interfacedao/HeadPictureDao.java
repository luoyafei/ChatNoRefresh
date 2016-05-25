package com.chat.interfacedao;

import java.util.List;

import com.chat.bean.HeadPicture;

public interface HeadPictureDao {

	public boolean insertHeadPicture(HeadPicture picture);
	public boolean updateHeadPicture(HeadPicture picture);
	public boolean deleteHeadPicture(Integer pictureId);
	public HeadPicture getHeadPictureInId(Integer pictureId);
	public List<HeadPicture> getAllHeadPicture();
}
