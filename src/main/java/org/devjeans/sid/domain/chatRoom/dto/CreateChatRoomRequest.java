package org.devjeans.sid.domain.chatRoom.dto;

import lombok.*;
import org.devjeans.sid.domain.chatRoom.entity.ChatParticipant;
import org.devjeans.sid.domain.chatRoom.entity.ChatRoom;
import org.devjeans.sid.domain.project.entity.Project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CreateChatRoomRequest {
    private Long projectId;
    private Long chatStarterMemberId; // 채팅을 시작한 사람

    public static ChatRoom toEntity(Project project, CreateChatRoomRequest createChatRoomRequest) {
//        List<ChatParticipant> participantList = new ArrayList<>();
//        participantList.add(starter);
//        participantList.add(pm);

        return ChatRoom.builder()
                .starterMemberId(createChatRoomRequest.chatStarterMemberId)
                .project(project)
                .recentChatTime(LocalDateTime.now())
                .build();
    }
}
