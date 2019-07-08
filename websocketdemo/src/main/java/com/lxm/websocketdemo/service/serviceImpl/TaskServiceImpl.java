package com.lxm.websocketdemo.service.serviceImpl;

import com.lxm.websocketdemo.service.TaskService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TaskServiceImpl implements TaskService {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String time() {
        return simpleDateFormat.format(new Date());
    }
}
