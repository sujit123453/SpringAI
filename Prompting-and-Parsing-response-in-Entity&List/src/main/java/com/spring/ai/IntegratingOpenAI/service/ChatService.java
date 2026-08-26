package com.spring.ai.IntegratingOpenAI.service;

import com.spring.ai.IntegratingOpenAI.entity.Tut;

import java.util.List;

public interface ChatService {
    List<Tut> chat(String s);
}
