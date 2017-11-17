import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor

public class Human {
    private Long ID;
    private int age;
    private int height;
    private String name;
}
