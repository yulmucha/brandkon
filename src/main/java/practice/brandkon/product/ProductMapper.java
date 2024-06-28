package practice.brandkon.product;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductDao> findAll(Long brandId, Long categoryId, String sort);
}