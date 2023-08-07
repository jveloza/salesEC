package com.sales.app.repository;

import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sales.app.entity.Prices;

@Repository("priceRepository")
public interface PriceRepository extends JpaRepository<Prices, Long>{

	@Query(value = "select p.id,"
			+ "p.brand_id,"
			+ "p.start_date,"
			+ "p.end_date,"
			+ "p.price_list,"
			+ "p.product_id,"
			+ "p.price,"
			+ "p.curr,"
			+ "max(p.priority) as priority "
			+ "from prices p "
			+ "join brand b on p.brand_id=b.id "
			+ "join product pr on p.product_id = pr.id "
			+ "where p.start_date = :start_date "
			+ "and p.brand_id = :brand_id "
			+ "and p.product_id = :product_id "
			+ "group by p.id,"
			+ "p.brand_id,"
			+ "p.start_date,"
			+ "p.end_date,"
			+ "p.price_list,"
			+ "p.product_id,"
			+ "p.price,"
			+ "p.curr",
			nativeQuery = true)
	public Optional<Prices> findByBrandProductDate(@Param("start_date") String start_date,
								@Param("brand_id") Long brand_id,
								@Param("product_id") Long product_id) throws NonUniqueResultException;
}
