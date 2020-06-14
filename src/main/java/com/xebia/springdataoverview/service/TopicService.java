package com.xebia.springdataoverview.service;

import com.xebia.springdataoverview.entity.Topic;
import com.xebia.springdataoverview.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic
            ("Invisible Man", 201), new Topic("Man in Space", 202)));

    public List<Topic> getAllTopics() {
//        return topics;
        List<Topic> topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add );  //Method references & Lambda Expression
        return topics;
    }

    public void addTopic(Topic topic) {

//        topics.add(topic);
        topicRepository.save(topic);  // USING CRUD REPOSITORY
    }

    public void UpdateTopic(int id, Topic topic) {
       /* for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId() == id) {
                topics.set(i, topic);

            }
        }*/
       topicRepository.save(topic);
       // IF ID DOEST not exit it updates auto. otherwise ADD


    }

    public void deleteTopic(int id) {
//        topics.removeIf(t->t.getId()==id);  //Lambda Expression
        /*for(int i=0;i<topics.size();i++)
        {
            Topic t=topics.get(i);
            if (t.getId()==id)
            {
                topics.remove(i);
            }
        }*/

        topicRepository.deleteById(id);

    }

    public Optional<Topic> findATopic(int id) {
//        System.out.println("Inside find a topic"+ id);
        return topicRepository.findById(id);

    }
}
