package ru.sokolov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sokolov.repository.LoggingRepository;

@Controller
@RequestMapping(value = "/api/tests")
public class MainController
{
    private final LoggingRepository repository;
    private final TestService service;

    @Autowired
    public MainController(LoggingRepository repository, TestService service) {
        this.repository = repository;
        this.service = service;
    }


    @RequestMapping(value= "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String selfTest (){
        return "Service is working";
    }

    @RequestMapping(value= "/loadTest1", method = RequestMethod.GET)
    @ResponseBody
    public String loadTest1 (){
        service.makeLoad();
        return "Test1 passed succesful!";
    }


//    @ResponseBody
//    @GetMapping(produces = PageAttributes.MediaType.APPLICATION_JSON_VALUE)
//    public List getAll() {
//        return StreamSupport
//                .stream(repository.findAll().spliterator(), false)
//                .collect(Collectors.toList());
//    }
/*
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = PageAttributes.MediaType.APPLICATION_JSON_VALUE, produces = PageAttributes.MediaType.APPLICATION_JSON_VALUE)
    public Fruit post(@RequestBody(required = false) Fruit fruit) {
        verifyCorrectPayload(fruit);

        return repository.save(fruit);
    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = PageAttributes.MediaType.APPLICATION_JSON_VALUE)
    public Fruit get(@PathVariable("id") Integer id) {
        verifyFruitExists(id);

        return repository.findOne(id);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Fruit put(@PathVariable("id") Integer id, @RequestBody(required = false) Fruit fruit) {
        verifyFruitExists(id);
        verifyCorrectPayload(fruit);

        fruit.setId(id);
        return repository.save(fruit);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        verifyFruitExists(id);

        repository.delete(id);
    }

    private void verifyFruitExists(Integer id) {
        if (!repository.exists(id)) {
            throw new RuntimeException(String.format("Fruit with id=%d was not found", id));
        }
    }

    private void verifyCorrectPayload(Fruit fruit) {
        if (Objects.isNull(fruit)) {
            throw new RuntimeException("Fruit cannot be null");
        }

        if (!Objects.isNull(fruit.getId())) {
            throw new RuntimeException("Id field must be generated");
        }
    }*/
}
