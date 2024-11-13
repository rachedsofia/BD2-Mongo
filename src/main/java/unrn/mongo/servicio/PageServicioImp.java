package unrn.mongo.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unrn.mongo.api.PageServicio;
import unrn.mongo.modelo.dto.PageDTO;
import unrn.mongo.repositorio.PageRepository;

import java.util.Date;

@Service
public class PageServicioImp implements PageServicio {

    @Autowired
    private PageRepository pageRepository;

    @Override
    public PageDTO findPage(String id) {
        return PageDTO.fromDocument(this.pageRepository.getPageById(id));
    }

    @Override
    public void createPage(PageDTO newPage) {
        this.pageRepository.createPage(
                newPage.getTitle(),
                newPage.getText(),
                newPage.getAuthor(),
                new Date()
        );
    }

}
