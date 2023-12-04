package dat3.testimonial.api;

import dat3.testimonial.dto.TestimonialRequest;
import dat3.testimonial.dto.TestimonialResponse;
import dat3.testimonial.entity.Testimonial;
import dat3.testimonial.service.TestimonialService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/testimonials")
public class TestimonialController {
    TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService) {
        this.testimonialService = testimonialService;
    }

    @GetMapping
    public List<TestimonialResponse> fetchAllTestimonials(){
        return testimonialService.fetchAllTestimonials();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTestimonial(@PathVariable int id){
        return testimonialService.deleteTestimonial(id);
    }
    @PostMapping
    public TestimonialResponse addTestimonial(@RequestBody TestimonialRequest testimonialRequest){
        return testimonialService.addTestimonial(testimonialRequest);
    }
}
