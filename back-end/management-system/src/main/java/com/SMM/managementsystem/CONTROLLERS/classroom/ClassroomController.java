package com.SMM.managementsystem.CONTROLLERS.classroom;

import com.SMM.managementsystem.EXTERNAL.Response;
import com.SMM.managementsystem.VIEWS.classroom.ClassroomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

/**
 * Class send responses to the online user on the state of the app.
 */

@RestController
@RequestMapping("/classroom")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomServiceImpl classroomService;

    public ResponseEntity<Response> getClassroom(){
        return ResponseEntity.ok(
                Response.builder()
                        .localDateTime(now())
                        .data(Map.of("students", classroomService.list(15)))
                        .developerMessage("Students retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
