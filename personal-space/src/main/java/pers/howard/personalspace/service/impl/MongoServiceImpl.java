package pers.howard.personalspace.service.impl;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import pers.howard.personalspace.model.IdItem;
import pers.howard.personalspace.service.MongoService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class MongoServiceImpl implements MongoService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    public int increaseId() {
        Query query = new Query(Criteria.where("name").is("user"));
        Update update = new Update();
        update.inc("num", 1);
        IdItem idItem = mongoTemplate.findAndModify(query, update, IdItem.class, "increase");
        return idItem.getNum();
    }

    @Override
    public String saveFile(InputStream inputStream, String filename, String contentType) {
        ObjectId id = gridFsTemplate.store(inputStream, filename, contentType);
        return id.toString();
    }

    public BufferedImage getImage(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        GridFSDownloadStream in = gridFSBucket.openDownloadStream(gridFSFile.getId());
        GridFsResource resource = new GridFsResource(gridFSFile, in);
        try {
            InputStream inputStream = resource.getInputStream();
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        } finally {
            in.close();
        }
    }
}
