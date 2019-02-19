package ru.hh.nab.example;

import ru.hh.nab.starter.NabApplication;

public class TodoMain {

  public static void main(String[] args) {
    NabApplication.builder()
            .configureJersey(TodoJerseyConfig.class)
            .registerResources(CORSResponseFilter.class).bindToRoot()
            .build().run(TodoConfig.class);
  }
}
