package com.company.app.services;

import com.company.app.models.FileInfo;
import com.company.app.models.User;
import com.company.app.repositories.FileInfoRepository;
import com.company.app.repositories.UsersRepository;
import com.company.app.utils.FilesStorageUtil;
import com.company.app.utils.ImagesFilesValidator;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

    @Autowired
    private FilesStorageUtil filesStorageUtil;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private ImagesFilesValidator imagesFilesValidator;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public String saveFile(MultipartFile file) {
        FileInfo fileInfo = filesStorageUtil.convertFromMultipart(file);
        fileInfoRepository.save(fileInfo);
        filesStorageUtil.copyToStorage(file, fileInfo.getStorageFileName());
        return fileInfo.getStorageFileName();
    }

    @Override
    @SneakyThrows
    public void writeFileToResponse(String fileName, HttpServletResponse response) {
        FileInfo fileInfo = fileInfoRepository.findOneByStorageFileName(fileName);
        response.setContentType(fileInfo.getType());
        InputStream inputStream = new FileInputStream(new File(fileInfo.getUrl()));
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }

    @Override
    public String saveImage(Authentication authentication, MultipartFile file) {
        imagesFilesValidator.validate(file);
        FileInfo fileInfo = filesStorageUtil.convertFromMultipart(file);
        fileInfoRepository.save(fileInfo);
        filesStorageUtil.copyToStorage(file, fileInfo.getStorageFileName());
        User user = usersRepository.findByEmail(authentication.getName()).get();
        if (user.getImage() != null){
            user.getImage().setUser(null);
            fileInfoRepository.save(user.getImage());
        }
        fileInfo.setUser(user);
        fileInfoRepository.save(fileInfo);
        return fileInfo.getStorageFileName();
    }
}
