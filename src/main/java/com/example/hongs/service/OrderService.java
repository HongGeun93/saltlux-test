package com.example.hongs.service;

import static com.example.hongs.domain.Order.createOrder;
import static com.example.hongs.domain.OrderItem.createOrderItem;

import com.example.hongs.domain.Delivery;
import com.example.hongs.domain.Member;
import com.example.hongs.domain.Order;
import com.example.hongs.domain.OrderItem;
import com.example.hongs.domain.item.Item;
import com.example.hongs.repository.ItemRepository;
import com.example.hongs.repository.MemberRepository;
import com.example.hongs.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    // 주문
    // 취소
    // 검색

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        // 엔티티 조회
        Member findMember = memberRepository.findOne(memberId);
        Item findItem = itemRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(findMember.getAddress());

        // 주문상품 생성
        OrderItem orderItem = createOrderItem(findItem, findItem.getPrice(), count);

        // 주문 생성
        Order order = createOrder(findMember, delivery, orderItem);

        // 주문 저장
        orderRepository.save(order);

        return order.getId();

    }

    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        
        // 주문 엔티티
        Order order = orderRepository.findOne(orderId);

        // 주문 취소
        order.cancel();
    }

//    /**
//     * 검색
//     */
//    public List<Order> findOrders(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }

}
