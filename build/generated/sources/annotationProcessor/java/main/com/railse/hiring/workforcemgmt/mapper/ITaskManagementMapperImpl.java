package com.railse.hiring.workforcemgmt.mapper;

import com.railse.hiring.workforcemgmt.dto.TaskManagementDto;
import com.railse.hiring.workforcemgmt.model.TaskManagement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-03T23:19:54+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.16 (Eclipse Adoptium)"
)
@Component
public class ITaskManagementMapperImpl implements ITaskManagementMapper {

    @Override
    public TaskManagementDto modelToDto(TaskManagement model) {
        if ( model == null ) {
            return null;
        }

        TaskManagementDto taskManagementDto = new TaskManagementDto();

        taskManagementDto.setId( model.getId() );
        taskManagementDto.setReferenceId( model.getReferenceId() );
        taskManagementDto.setReferenceType( model.getReferenceType() );
        taskManagementDto.setTask( model.getTask() );
        taskManagementDto.setDescription( model.getDescription() );
        taskManagementDto.setStatus( model.getStatus() );
        taskManagementDto.setAssigneeId( model.getAssigneeId() );
        taskManagementDto.setTaskDeadlineTime( model.getTaskDeadlineTime() );
        taskManagementDto.setPriority( model.getPriority() );

        return taskManagementDto;
    }

    @Override
    public TaskManagement dtoToModel(TaskManagementDto dto) {
        if ( dto == null ) {
            return null;
        }

        TaskManagement taskManagement = new TaskManagement();

        taskManagement.setId( dto.getId() );
        taskManagement.setReferenceId( dto.getReferenceId() );
        taskManagement.setReferenceType( dto.getReferenceType() );
        taskManagement.setTask( dto.getTask() );
        taskManagement.setDescription( dto.getDescription() );
        taskManagement.setStatus( dto.getStatus() );
        taskManagement.setAssigneeId( dto.getAssigneeId() );
        taskManagement.setTaskDeadlineTime( dto.getTaskDeadlineTime() );
        taskManagement.setPriority( dto.getPriority() );

        return taskManagement;
    }

    @Override
    public List<TaskManagementDto> modelListToDtoList(List<TaskManagement> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<TaskManagementDto> list = new ArrayList<TaskManagementDto>( modelList.size() );
        for ( TaskManagement taskManagement : modelList ) {
            list.add( modelToDto( taskManagement ) );
        }

        return list;
    }
}
