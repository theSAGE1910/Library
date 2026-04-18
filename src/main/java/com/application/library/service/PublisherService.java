package com.application.library.service;

import com.application.library.entity.Publisher;
import com.application.library.respository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id + "!"));
    }

    public void createPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long id) {
        Publisher publisher = findPublisherById(id);
        publisherRepository.delete(publisher);
    }
}
