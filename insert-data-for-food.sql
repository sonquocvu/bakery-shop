use cake_shop;
show tables;
select * from food;
insert into food (user_id, category_id, name, description, price)
values
(5, 1, 'Bánh mì hoa cúc', 'Khi thưởng thức, bạn có thể nhanh chóng cảm nhận được vị thơm ngọt của nguyên liệu bơ, sữa làm nên chúng. Không chỉ vậy, vị mạch nha hoặc hạnh nhân béo ngậy cũng được xem là một trong những yếu tố giúp loại bánh này trở nên đặc biệt hơn', 60000),
(5, 1, 'Bánh sừng bò', 'Bánh sừng bò có vị ngọt thanh nhẹ, giòn tan bên ngoài và hơi xốp bên trong. Khi ăn, bạn có thể cảm nhận được vị nguyên thủy của bột bánh pha lẫn chút hương sữa thơm lừng', 50000),
(5, 1, 'Bánh mì Baguette', 'Loại bánh này mặc dù đơn giản, dễ ăn nhưng cũng rất dễ gây nghiện. Điều này là bởi chúng lúc nào cũng thơm lừng nức mũi, kết hợp với phần vỏ giòn tan và ruột bánh cực kì mềm mại, thơm ngon vị bơ sữa', 70000),
(5, 1, 'Bánh mì Pain de Mie', 'Pain de Mie sẽ được phết thêm bơ lạc, ăn kèm salad, trứng luộc hoặc bất kỳ loại thực phẩm yêu thích nào khác để tạo nên bữa sáng giàu dinh dưỡng', 80000),
(5, 2, 'Bánh gato', 'Đây có lẽ là một trong 5 loại bánh kem sinh nhật quen thuộc nhất với chúng ta phải không nào. Mẫu mã các loại bánh càng ngày càng đẹp, hương vị bánh và kem cũng dần thay đổi để phù hợp với xu thế', 90000),
(5, 2, 'Tiramisu', 'Chiếc bánh này còn có tên là “pick me up”, hay dịch tiếng Việt có nghĩa là “hãy mang em đi”. Bánh có xuất xứ từ Ý, tượng trưng cho tình yêu mãnh liệt do bánh vừa có vị đắng vừa có vị ngọt cũng như tình yêu vừa hạnh phúc vừa đau khổ. Ngoài ra, bánh được giới bánh ngọt gọi là nữ hoàng của mọi loại bánh.Về độ nổi tiếng thì có lẽ không bánh nào qua được. Người đam mê bánh ngọt lẫn người thường có lẽ đều đã một lần nghe đến tên bánh này', 100000),
(5, 2, 'Bánh mousse', 'Mousse là một loại bánh có lớp kem mát lạnh mềm mịn, tan trong miệng, đây là những đặc trưng đầu tiên khi người ta nghĩ đến mousse. Với ý nghĩa là "bọt" trong tiếng Pháp, mousse chính là chiếc bánh có vẻ ngoài đẹp mắt với lớp bánh gato mỏng bên dưới, phía trên là kem mịn, tan nhanh tự bọt biển chỉ để lại sự vấn vương nơi đầu lưỡi thực khách.
Chỉ với lòng trắng trứng đánh bông, kết hợp với các nguyên liệu khác như gelatin, kem tươi hay hương trái cây mà mousse lại trở thành món tráng miệng không thể thiếu và được lòng bao nhiêu người chỉ với một lần nếm qua.
Thuộc dòng bánh lạnh nên mousse ăn man mát, vị béo ngậy của kem tươi hòa cùng các hương vị thêm vào tạo nên sự độc đáo của bánh. Hương vị thêm vào mousse cũng vô cùng đa dạng và phong phú như hương vị của các loại trái cây, chocolate, trà xanh,…', 110000),
(5, 2, 'Cheesecake', 'Bánh cheesecake không còn xa lạ gì với người dân Việt Nam, đặc biệt là giới trẻ bởi bánh hiện được bán và trưng bày khắp các tiệm bánh đặc biệt là các quán coffee và trà. Tiệm coffee và trà có thể không có đủ loại bánh nhưng loại bánh chắc chắn họ nghĩ đến bán đầu tiên có lẽ là bánh cheesecake. Cheesecake có rất nhiều biến tấu từ cheesecake cơ bản cho đến cheesecake trái cây (chanh dây, dâu, việt quất, phúc bồn từ, v…v…). Ngoài ra còn có cheesecake cà phê, trà xanh, chocolate và oreo. Món bánh được lòng mọi người nhất mà hầu như tiệm cà phê hay trà nào cũng có bán đó là bánh cheesecake chanh dây', 120000),
(5, 2, 'Bánh kem lạnh', 'Dòng bánh này khá mới lạ và vô cùng độc đáo. Thay vì phần cốt bánh gato thông thường, nguyên liệu của dòng bánh này là kem lạnh mà chúng ta vẫn hay thưởng thức. Kem được đổ vào khuôn bánh gato, cho vào ngăn đá tủ lạnh cho đông lại, tách ra và xếp các lớp mỏng lại với nhau và trang trí thành 1 chiếc bánh lớn.
Vì thành phần chủ yếu là kem lạnh nên dòng bánh này sẽ thích hợp với các bữa tiệc sinh nhật trong phòng có bật điều hòa hơn', 130000),
(5, 2, 'Bánh su kem', 'Bánh su kem (Chou À La Crème) là chiếc bánh nhỏ xinh có xuất xứ từ đất nước Pháp ngọt ngào. Bánh su kem thơm ngon kết hợp với lớp kem béo mịn cho bạn một hương vị thật khó quên. Bạn có thể dễ dàng trang trí món bánh này theo nhiều hình dáng bắt mắt khác nhau phù hợp để tặng trong rất nhiều dịp như sinh nhật, lễ,....', 140000),
(5, 3, 'Bánh Macaron Pháp', 'Đây là một loại bánh ngọt của Pháp, bánh được làm từ lòng trắng trứng, đường bột, đường cát, bột hạnh nhân và một ít phẩm màu tự nhiên. Nhân bánh thường là mứt, chocolate hoặc kem bơ kẹp ở giữa. Bánh macaron nổi bật với những hương vị truyền thống như mâm xôi, chocolate và những hương vị mới như nấm và trà xanh. Với vị giòn tan của vỏ bánh, béo ngậy của phần nhân, cùng vẻ ngoài đáng yêu và nhiều màu sắc bắt mắt, đây là một món bánh đặc trưng trong các cửa hàng bánh ngọt tại Pháp', 150000),
(5, 3, 'Bánh Black Forest Đức', 'Black Forest, người Đức hay gọi là bánh rừng đen, đây là một món tráng miệng, có nguồn gốc xuất xứ từ Đức. Bánh bao gồm nhiều lớp bánh bông lan chocolate xen kẽ giữa các lớp kem tươi trộn với anh đào, sau đó nó được phủ một lớp kem trên cùng, rồi được trang trí bằng quả anh đào đen và chocolate vụn. Điểm đặc trưng của loại bánh này nằm ở loại rượu brandy anh đào, vị rượu đặc trưng này đã làm nên tên tuổi cho bánh Balck Forest ngày nay', 160000),
(5, 3, 'Bánh táo Mỹ', 'Bánh táo được xem là biểu tượng của nền văn hóa ẩm thực Mỹ, thể hiện sự thịnh vượng và là niềm tự hào trong suốt những năm của thế kỷ 19 và 20 của đất nước này, Bánh táo Mỹ với phần vỏ bánh mỏng, giòn mềm, ẩn chứa phần nhân táo thơm ngọt, điểm chút vị chua dịu của trái cây quả sẽ là một lựa chọn hoàn hảo cho những tín đồ bánh ngọt trên toàn Thế Giới', 170000),
(5, 4, 'Trà sen Tây Hồ', 'Những bông sen sau khi được hái vào buổi sáng sớm sẽ được đem về để tách lấy gạo sen ướp trà thái nguyên cao cấp hoặc trà shan tuyết cổ thụ, phần còn lại của sen sẽ bỏ đi. Quá trình ướp trà sẽ trải qua thời gian khoảng 7 – 10 ngày với số lần ướp từ 4 – 7 lần cho một mẻ trà khi thành công. Trà Sen Tây Hồ có những cánh trà nhỏ, trà mang hương thơm ngọt ngào của hoa sen tự nhiên, một chút chát ở tiền vị nhưng hậu vị lại ngọt một cách đậm đà và lưu lại trong khoang miệng rất lâu, tạo cho người thưởng thức trà một cảm giác nhẹ nhàng và êm ả', 40000),
(5, 4, 'Trà ướp hoa lài', 'Trà ướp hoa lài là sản phẩm được tạo ra từ lá trà tươi ngon ướp cùng với những bông hoa lài có mùi thơm đặc trưng. Trà lài có chứa một lượng dầu etheric mà lượng dầu này có tác dụng tăng cường năng lượng, hỗ trợ tối đa trong việc đào thải độc tố cho cơ thể đồng thời giúp giảm cân và làm đẹp da. Trà hoa lài thường được thu hái vào buổi tầm chiều, vì thời điểm này sẽ đảm bảo được độ tinh khiết và tươi xanh nhất. Trà lài mang hương vị ngọt ngào tinh tế, nhẹ nhàng như mùi hương của thiếu nữ. Chính vì thế mà dễ làm hài lòng của giới thưởng trà', 50000),
(5, 4, 'Trà nõn tôm', 'Trà Nõn Tôm là loại trà ngon đúng thứ 2 sau trà đinh. Trà nõn tôm là phần trà được làm từ nõn trà non nhất và chứa nhiều thành phần dinh dưỡng nhất trong búp trà. Lượng trà dùng để pha là rất ít, chỉ cần một lượng bằng nửa những loại trà khác là đã có ấm trà thơm ngon hơn hẳn. Chính vì vậy mà những người sành trà thường tìm đến loại trà này bởi hương vị say mê lòng người', 30000);