package com.maiquan.aladdin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maiquan.aladdin.dao.IProductSkuDao;
import com.maiquan.aladdin.domain.ProductSku;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestProductSkuService {

	@Autowired
	private IProductSkuDao productSkuDao;
	
	@Test
	public void testGetSkuByID() {
		
	}
	
	@Test
	public void testGetSkuByProductID() {
		
		ProductSku ps1 = new ProductSku();
		ps1.setID(1);
		ps1.setProductID(100);
		ps1.setApplyPrice(344L);
		ps1.setCreateTime(new Date());
		ps1.setSkuImg("https://.jpg");
		ps1.setSkuPrice(355L);
		ps1.setSkuStock(33);
		ps1.setUid(35);
		
		ProductSku ps2 = new ProductSku();
		ps2.setID(2);
		ps2.setProductID(100);
		ps2.setApplyPrice(144L);
		ps2.setCreateTime(new Date());
		ps2.setSkuImg("https://234234-.jpg");
		ps2.setSkuPrice(155L);
		ps2.setSkuStock(76);
		ps2.setUid(35);
		
		List<ProductSku> skus = new ArrayList<ProductSku>();
		skus.add(ps1);
		skus.add(ps2);
		
		productSkuDao.addProductSkuListWithSameProductID(skus);
		
		List<ProductSku> list = productSkuDao.getProductSkuByProductID(100);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		list = productSkuDao.getProductSkuByProductID(1111);
		System.out.println(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}

}
