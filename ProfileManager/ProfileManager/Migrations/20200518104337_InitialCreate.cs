using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace ProfileManager.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Profiles",
                columns: table => new
                {
                    id = table.Column<long>(nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    name = table.Column<string>(nullable: true),
                    surname = table.Column<string>(nullable: true),
                    birthday = table.Column<DateTime>(nullable: false),
                    email = table.Column<string>(nullable: true),
                    image = table.Column<string>(maxLength: 10000000, nullable: true),
                    proprietario_id = table.Column<long>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Profiles", x => x.id);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Profiles");
        }
    }
}
