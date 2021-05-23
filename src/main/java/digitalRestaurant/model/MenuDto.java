package digitalRestaurant.model;

import java.nio.file.Path;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MenuDto {
    private String imageName;
    private Path imgNameAndPath;
    private boolean imageAlredyExistInTheDataBaseOrNot = false;
    private String menuName;
    private MultipartFile originalImageFile;
    private String uploadDirectory;

  


    public MenuDto() {
    }

    public MenuDto(String menuName, MultipartFile originalImageFile, String uploadDirectory) {
        this.menuName = menuName;
        this.originalImageFile = originalImageFile;
        this.uploadDirectory = uploadDirectory;
    }





    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public Path getImgNameAndPath() {
        return imgNameAndPath;
    }
    public void setImgNameAndPath(Path imgNameAndPath) {
        this.imgNameAndPath = imgNameAndPath;
    }
    public boolean isImageAlredyExistInTheDataBaseOrNot() {
        return imageAlredyExistInTheDataBaseOrNot;
    }
    public void setImageAlredyExistInTheDataBaseOrNot(boolean imageAlredyExistInTheDataBaseOrNot) {
        this.imageAlredyExistInTheDataBaseOrNot = imageAlredyExistInTheDataBaseOrNot;
    }
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public MultipartFile getOriginalImageFile() {
        return originalImageFile;
    }
    public void setOriginalImageFile(MultipartFile originalImageFile) {
        this.originalImageFile = originalImageFile;
    }
    public String getUploadDirectory() {
        return uploadDirectory;
    }
    public void setUploadDirectory(String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
    }


    

}
