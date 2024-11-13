package unrn.mongo.api;


import unrn.mongo.modelo.dto.PageDTO;

public interface PageServicio {
    PageDTO findPage(String id);

    void createPage(PageDTO newPage);

}
