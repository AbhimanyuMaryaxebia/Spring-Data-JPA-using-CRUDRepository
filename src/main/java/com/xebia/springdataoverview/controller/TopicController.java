package com.xebia.springdataoverview.controller;

import com.xebia.springdataoverview.entity.Topic;
import com.xebia.springdataoverview.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/topic")
    public List<Topic> allTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topic/{foo}")
    public String getId(@PathVariable("foo") int id) {
        topicService.findATopic(id);
        return "Retriving a record Successful";
    }

    @PostMapping("/topic")
    public String addTopic(Topic topic) {
        topicService.addTopic(topic);
        return "Addition Successful";
    }

    @PutMapping("/topic/{id}")
    public String UpdateTopic(Topic topic, @PathVariable int id) {
        topicService.UpdateTopic(id, topic);
        return "Update Successful";
    }

    @DeleteMapping("/topic/{id}")
    public String deleteTopic(@PathVariable int id) {
        topicService.deleteTopic(id);
        return "Delete Successful";
    }


}
