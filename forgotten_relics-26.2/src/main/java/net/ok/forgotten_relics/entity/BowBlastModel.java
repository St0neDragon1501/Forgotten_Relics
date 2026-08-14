package net.ok.forgotten_relics.entity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.rendertype.RenderTypes;

public class BowBlastModel extends EntityModel<BowBlastRenderState> {

    private final ModelPart bone;
    private final ModelPart bb_main;

    public BowBlastModel(ModelPart root) {
        super(root, RenderTypes::entityCutoutCull);

        this.bone = root.getChild("bone");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // BONE
        PartDefinition bone = partdefinition.addOrReplaceChild(
                "bone",
                CubeListBuilder.create()
                        .texOffs(0, 26)
                        .addBox(
                                -5.0F, 0.0F, -1.0F,
                                6.0F, 0.0F, 8.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(2.0F, 17.0F, 11.0F)
        );

        bone.addOrReplaceChild(
                "cube_r1",
                CubeListBuilder.create()
                        .texOffs(28, 26)
                        .addBox(
                                -5.0F, 0.0F, -1.0F,
                                6.0F, 0.0F, 8.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offsetAndRotation(
                        -2.0F, -2.0F, 0.0F,
                        0.0F, 0.0F, -1.5708F
                )
        );

        // MAIN BODY
        PartDefinition bb_main = partdefinition.addOrReplaceChild(
                "bb_main",
                CubeListBuilder.create()
                        .texOffs(1, 35)
                        .addBox(
                                -0.5F, -7.5F, -14.0F,
                                1.0F, 1.0F, 6.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(16, 41)
                        .addBox(
                                -2.0F, -9.0F, -10.0F,
                                4.0F, 4.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(40, 41)
                        .addBox(
                                -1.0F, -10.0F, -10.0F,
                                2.0F, 6.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(0, 0)
                        .addBox(
                                -1.0F, -8.0F, -8.0F,
                                2.0F, 2.0F, 24.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(28, 41)
                        .addBox(
                                -1.5F, -8.5F, -11.0F,
                                3.0F, 3.0F, 3.0F,
                                new CubeDeformation(0.0F)
                        )
                        .texOffs(17, 35)
                        .addBox(
                                -1.0F, -7.5F, -13.0F,
                                2.0F, 1.0F, 5.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offset(0.0F, 24.0F, 0.0F)
        );

        bb_main.addOrReplaceChild(
                "cube_r2",
                CubeListBuilder.create()
                        .texOffs(33, 35)
                        .addBox(
                                0.0F, -1.0F, -4.0F,
                                2.0F, 1.0F, 5.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offsetAndRotation(
                        0.5F, -6.0F, -9.0F,
                        0.0F, 0.0F, -1.5708F
                )
        );

        bb_main.addOrReplaceChild(
                "cube_r3",
                CubeListBuilder.create()
                        .texOffs(0, 42)
                        .addBox(
                                -1.0F, -2.0F, -1.0F,
                                2.0F, 6.0F, 2.0F,
                                new CubeDeformation(0.0F)
                        ),
                PartPose.offsetAndRotation(
                        -1.0F, -7.0F, -9.0F,
                        0.0F, 0.0F, -1.5708F
                )
        );

        return LayerDefinition.create(
                meshdefinition,
                64,
                64
        );
    }

    @Override
    public void setupAnim(BowBlastRenderState state) {
        super.setupAnim(state);
    }
}