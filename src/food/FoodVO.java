package food;

public class FoodVO {

	String kind;
	int distance;
	int price;
	String name;
	String map;
	int review;

	public FoodVO() {

	}

	public FoodVO(String kind,String name, int price,int distance,int review, String map) {
		super();
		this.kind = kind;
		this.distance = distance;
		this.price = price;
		this.name = name;
		this.map = map;
		this.review = review;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "FoodVO [kind=" + kind + ", distance=" + distance + "m, price=" + price + "¿ø´ë, name=" + name + ", map="
				+ map + ", review=" + review + "°Ç]";
	}


}
