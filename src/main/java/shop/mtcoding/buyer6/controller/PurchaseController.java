package shop.mtcoding.buyer6.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer6.dto.PurchaseAllDto;
import shop.mtcoding.buyer6.model.PurchaseRepository;
import shop.mtcoding.buyer6.model.User;
import shop.mtcoding.buyer6.service.PurchaseService;

@Controller
public class PurchaseController {

    @Autowired
    HttpSession session;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    PurchaseRepository purchaseRepository;

    @PostMapping("/product/{id}/pruchase")
    public String purchase(@PathVariable int id, int count) {
        // 인증
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        int res = purchaseService.구매하기(id, principal.getId(), count);
        if (res == -1) {
            return "redirect:/notfound";
        }

        return "redirect:/";
    }

    @GetMapping("/product/purchase")
    public String list(Model model) {
        // 인증
        User user = (User) session.getAttribute("principal");
        if (user == null) {
            return "redirect:/notfound";
        }

        List<PurchaseAllDto> purchaseList = purchaseRepository.findByUserId(user.getId());
        model.addAttribute("purchaseList", purchaseList);

        return "purchase/list";
    }

    @PostMapping("/purchase/{id}/delete")
    public String delete(@PathVariable int id) {
        // 인증
        User user = (User) session.getAttribute("principal");
        if (user == null) {
            return "redirect:/notfound";
        }

        int res = purchaseService.삭제하기(id);
        if (res != 1) {
            return "redirect:/notfound";
        }

        return "redirect:/product/purchase";
    }
}
