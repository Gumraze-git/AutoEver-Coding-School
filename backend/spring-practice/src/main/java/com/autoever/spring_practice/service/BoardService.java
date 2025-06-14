package com.autoever.spring_practice.service;

import java.util.ArrayList;
import java.util.List;

import com.autoever.spring_practice.controller.BoardResDto;
import com.autoever.spring_practice.controller.BoradController;
import com.autoever.spring_practice.dto.BoardWriteDto;
import com.autoever.spring_practice.dto.PageResDto;
import com.autoever.spring_practice.entity.Board;
import com.autoever.spring_practice.entity.Member;
import com.autoever.spring_practice.repository.BoardRepository;
import com.autoever.spring_practice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoradController boradController;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    // Entity를 Dto로 변환
    private BoardResDto convertEntityToDto(Board board) {
        BoardResDto boardResDto = new BoardResDto();
        boardResDto.setId(board.getId());
        boardResDto.setTitle(board.getTitle());
        boardResDto.setContent(board.getContent());
        boardResDto.setImg(board.getImg());
        boardResDto.setCreateTime(board.getCreateTime());
        boardResDto.setWriterEmail(board.getMember().getEmail()); // 연관 관계 매핑으로 정보를 가져옴
        return boardResDto;
    }

    // DTO를 Entity로 변환
    private Board convertDtoToEntity(BoardWriteDto boardWriteDto) {
        Member member = memberRepository.findByEmail(boardWriteDto.getEmail())
                .orElseThrow(() -> new RuntimeException("해당 회원이 존재하지 않습니다."));
        Board board = new Board();
        board.setTitle(boardWriteDto.getTitle());
        board.setContent(boardWriteDto.getContent());
        board.setImg(boardWriteDto.getImg());
        board.setMember(member);
        return board;
    }

    // 게시글 등록
    public boolean addBoard(BoardWriteDto boardWriteDto) {
        try {
            Board board = convertDtoToEntity(boardWriteDto);
            boardRepository.save(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 등록 실패 {}", e.getMessage());
            return false;
        }
    }

    // 게시글 단건 조회: 입력 게시글은 ID, 반환값 Board
    public BoardResDto getBoradById(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("해당 게시물이 없습니다."));
        return convertEntityToDto(board);
    }

    // 게시글 수정: 반환값 boolean
    public boolean updateBoard(Long boardId, BoardWriteDto boardWriteDto) {
        try {
            Board board = boardRepository.findById(boardId)
                    .orElseThrow(() -> new RuntimeException("해당 게시글이 없습니다."));
            Member member = memberRepository.findByEmail(boardWriteDto.getEmail())
                    .orElseThrow(() -> new RuntimeException("해당 회원이 존재하지 않습니다."));
            board.setTitle(boardWriteDto.getTitle());
            board.setContent(boardWriteDto.getContent());
            board.setImg(boardWriteDto.getImg());
            board.setMember(member);
            boardRepository.save(board);
            return true;
        } catch (RuntimeException e) {
            log.error("게시글 수정 실패: {}", e.getMessage());
            return false;
        }
    }

    // 게시글 삭제: 반환값 Boolean
    public boolean deleteBoard(Long boardId) {
        try {
            Board board = boardRepository.findById(boardId)
                    .orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다."));
            boardRepository.delete(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 삭제에 실패했습니다.");
            return false;
        }
    }

    // 게시글 검색: 반환값 List<Board>
    public List<BoardResDto> searchBoard(String searchWord) {
        List<Board> boards = boardRepository.findByTitleContaining(searchWord);
        List<BoardResDto> boardResDtoList = new ArrayList<>();

        for (Board board : boards) {
            boardResDtoList.add(convertEntityToDto(board));
        }
        return boardResDtoList;
    }

    // 게시글 페이지네이션 처리
    public PageResDto<BoardResDto> getBoardPageList(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Board> boardPage = boardRepository.findAll(pageRequest);
        Page<BoardResDto> boardResDtoPage = boardPage.map(this::convertEntityToDto);
        return new PageResDto<>(boardResDtoPage);
    }
}
