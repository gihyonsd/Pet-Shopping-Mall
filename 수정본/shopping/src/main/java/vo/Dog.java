package vo;

public class Dog {
	
	private int id;
	private String kind;
	private String GoodsName;
	private int price;
	private String image;
	private String content;
	private int readcount;
	
	public Dog(int id, String kind, String GoodsName, int price, String image, String content, int readcount) {
		super();
		this.id = id;
		this.kind = kind;
		this.GoodsName = GoodsName;
		this.price = price;
		this.image = image;
		this.content = content;
		this.readcount = readcount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return GoodsName;
	}
	public void setName(String GoodsName) {
		this.GoodsName = GoodsName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
}