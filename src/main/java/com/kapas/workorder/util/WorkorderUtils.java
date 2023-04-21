package com.kapas.workorder.util;

import com.kapas.util.AppUtils;
import com.kapas.workorder.model.WorkflowTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkorderUtils {

    Logger logger = LoggerFactory.getLogger(WorkorderUtils.class);

    private static String workorderIdPrefix = "WO";

    public static String createWorkorderId(String suffix) {
        String workorderId = workorderIdPrefix;
        workorderId += "_" + AppUtils.todaysDateString("dd-MM-YYYY");
        workorderId += "_" + suffix;
        return workorderId;
    }

    public static Map<String, WorkflowTask> getTaskMapByTaskId(List<WorkflowTask> taskList) {
        return taskList.stream().collect(Collectors.toMap(WorkflowTask::getTaskId,
                        workflowTask -> workflowTask));
    }

    public static void main(String[] args) {
        List<WorkflowTask> taskList = new ArrayList<>();
        WorkflowTask t1 = new WorkflowTask();
        t1.setTaskId("AAA");
        WorkflowTask t2 = new WorkflowTask();

        t2.setTaskId("BBB");

        taskList.add(t1);
        taskList.add(t2);
        System.out.println(getTaskMapByTaskId(taskList));

    }
}
