package com.commerce.review.DAO.DAOImpl;

import com.commerce.review.DAO.ProductReviewDAO;
import com.commerce.review.model.ProductReview;

import java.util.HashMap;
import java.util.Map;


public class InMemoryDaoImpl implements ProductReviewDAO {

    private Map<String,ProductReview> productReviewMap = new HashMap<>();
    @Override
    public ProductReview getProductReview(String productId) {
        return productReviewMap.get(productId);
    }

    @Override
    public boolean addProductReview(ProductReview productReview) {
        if(productReviewMap.size() == 0){
            productReviewMap.put(productReview.getProductId(),productReview);
        }else{
            if(productReviewMap.containsKey(productReview.getProductId())){
                System.out.println("Product already exists !");
                return false;
            }else{
                productReviewMap.put(productReview.getProductId(),productReview);
            }
        }
        return true;
    }

    @Override
    public boolean updateProductReview(ProductReview toUpdateProductReview) {
        String productId = toUpdateProductReview.getProductId();
        if(productReviewMap.size() > 0 && productReviewMap.containsKey(productId)){
            productReviewMap.put(productId,toUpdateProductReview);
            return true;
        }
        System.out.println("Product does not exist for update !");
        return false;
    }

    @Override
    public boolean deleteProductReview(String productId) {
        if(productReviewMap.size() > 0 && productReviewMap.containsKey(productId)){
            productReviewMap.remove(productId);
            return true;
        }
        return false;
    }
}
