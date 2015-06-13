package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Book.ddl ++ Library.ddl ++ Member.ddl ++ Rental.ddl
  
  /** Entity class storing rows of table Book
   *  @param bookId Database column BOOK_ID DBType(BIGINT), AutoInc, PrimaryKey
   *  @param title Database column TITLE DBType(VARCHAR), Length(255,true)
   *  @param author Database column AUTHOR DBType(VARCHAR), Length(100,true)
   *  @param publisher Database column PUBLISHER DBType(VARCHAR), Length(255,true)
   *  @param issueDate Database column ISSUE_DATE DBType(TIMESTAMP)
   *  @param insTime Database column INS_TIME DBType(TIMESTAMP)
   *  @param updTime Database column UPD_TIME DBType(TIMESTAMP)
   *  @param insUserEmail Database column INS_USER_EMAIL DBType(VARCHAR), Length(100,true)
   *  @param updUserEmail Database column UPD_USER_EMAIL DBType(VARCHAR), Length(100,true) */
  case class BookRow(bookId: Long, title: String, author: String, publisher: String, issueDate: java.sql.Timestamp, insTime: java.sql.Timestamp, updTime: java.sql.Timestamp, insUserEmail: String, updUserEmail: String)
  /** GetResult implicit for fetching BookRow objects using plain SQL queries */
  implicit def GetResultBookRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[BookRow] = GR{
    prs => import prs._
    BookRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String]))
  }
  /** Table description of table BOOK. Objects of this class serve as prototypes for rows in queries. */
  class Book(_tableTag: Tag) extends Table[BookRow](_tableTag, "BOOK") {
    def * = (bookId, title, author, publisher, issueDate, insTime, updTime, insUserEmail, updUserEmail) <> (BookRow.tupled, BookRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (bookId.?, title.?, author.?, publisher.?, issueDate.?, insTime.?, updTime.?, insUserEmail.?, updUserEmail.?).shaped.<>({r=>import r._; _1.map(_=> BookRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column BOOK_ID DBType(BIGINT), AutoInc, PrimaryKey */
    val bookId: Column[Long] = column[Long]("BOOK_ID", O.AutoInc, O.PrimaryKey)
    /** Database column TITLE DBType(VARCHAR), Length(255,true) */
    val title: Column[String] = column[String]("TITLE", O.Length(255,varying=true))
    /** Database column AUTHOR DBType(VARCHAR), Length(100,true) */
    val author: Column[String] = column[String]("AUTHOR", O.Length(100,varying=true))
    /** Database column PUBLISHER DBType(VARCHAR), Length(255,true) */
    val publisher: Column[String] = column[String]("PUBLISHER", O.Length(255,varying=true))
    /** Database column ISSUE_DATE DBType(TIMESTAMP) */
    val issueDate: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("ISSUE_DATE")
    /** Database column INS_TIME DBType(TIMESTAMP) */
    val insTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("INS_TIME")
    /** Database column UPD_TIME DBType(TIMESTAMP) */
    val updTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("UPD_TIME")
    /** Database column INS_USER_EMAIL DBType(VARCHAR), Length(100,true) */
    val insUserEmail: Column[String] = column[String]("INS_USER_EMAIL", O.Length(100,varying=true))
    /** Database column UPD_USER_EMAIL DBType(VARCHAR), Length(100,true) */
    val updUserEmail: Column[String] = column[String]("UPD_USER_EMAIL", O.Length(100,varying=true))
  }
  /** Collection-like TableQuery object for table Book */
  lazy val Book = new TableQuery(tag => new Book(tag))
  
  /** Entity class storing rows of table Library
   *  @param libraryId Database column LIBRARY_ID DBType(BIGINT), AutoInc, PrimaryKey
   *  @param bookId Database column BOOK_ID DBType(BIGINT)
   *  @param insTime Database column INS_TIME DBType(TIMESTAMP)
   *  @param updTime Database column UPD_TIME DBType(TIMESTAMP)
   *  @param insUserEmail Database column INS_USER_EMAIL DBType(VARCHAR), Length(100,true)
   *  @param updUserEmail Database column UPD_USER_EMAIL DBType(VARCHAR), Length(100,true) */
  case class LibraryRow(libraryId: Long, bookId: Long, insTime: java.sql.Timestamp, updTime: java.sql.Timestamp, insUserEmail: String, updUserEmail: String)
  /** GetResult implicit for fetching LibraryRow objects using plain SQL queries */
  implicit def GetResultLibraryRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp], e2: GR[String]): GR[LibraryRow] = GR{
    prs => import prs._
    LibraryRow.tupled((<<[Long], <<[Long], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String]))
  }
  /** Table description of table LIBRARY. Objects of this class serve as prototypes for rows in queries. */
  class Library(_tableTag: Tag) extends Table[LibraryRow](_tableTag, "LIBRARY") {
    def * = (libraryId, bookId, insTime, updTime, insUserEmail, updUserEmail) <> (LibraryRow.tupled, LibraryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (libraryId.?, bookId.?, insTime.?, updTime.?, insUserEmail.?, updUserEmail.?).shaped.<>({r=>import r._; _1.map(_=> LibraryRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column LIBRARY_ID DBType(BIGINT), AutoInc, PrimaryKey */
    val libraryId: Column[Long] = column[Long]("LIBRARY_ID", O.AutoInc, O.PrimaryKey)
    /** Database column BOOK_ID DBType(BIGINT) */
    val bookId: Column[Long] = column[Long]("BOOK_ID")
    /** Database column INS_TIME DBType(TIMESTAMP) */
    val insTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("INS_TIME")
    /** Database column UPD_TIME DBType(TIMESTAMP) */
    val updTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("UPD_TIME")
    /** Database column INS_USER_EMAIL DBType(VARCHAR), Length(100,true) */
    val insUserEmail: Column[String] = column[String]("INS_USER_EMAIL", O.Length(100,varying=true))
    /** Database column UPD_USER_EMAIL DBType(VARCHAR), Length(100,true) */
    val updUserEmail: Column[String] = column[String]("UPD_USER_EMAIL", O.Length(100,varying=true))
    
    /** Foreign key referencing Book (database name library_ibfk_1) */
    lazy val bookFk = foreignKey("library_ibfk_1", bookId, Book)(r => r.bookId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Library */
  lazy val Library = new TableQuery(tag => new Library(tag))
  
  /** Entity class storing rows of table Member
   *  @param memberId Database column MEMBER_ID DBType(BIGINT), AutoInc, PrimaryKey
   *  @param memberName Database column MEMBER_NAME DBType(VARCHAR), Length(20,true)
   *  @param email Database column EMAIL DBType(VARCHAR), Length(100,true)
   *  @param password Database column PASSWORD DBType(VARCHAR), Length(255,true)
   *  @param role Database column ROLE DBType(VARCHAR), Length(5,true)
   *  @param insTime Database column INS_TIME DBType(TIMESTAMP)
   *  @param updTime Database column UPD_TIME DBType(TIMESTAMP) */
  case class MemberRow(memberId: Long, memberName: String, email: String, password: String, role: String, insTime: java.sql.Timestamp, updTime: java.sql.Timestamp)
  /** GetResult implicit for fetching MemberRow objects using plain SQL queries */
  implicit def GetResultMemberRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[MemberRow] = GR{
    prs => import prs._
    MemberRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table MEMBER. Objects of this class serve as prototypes for rows in queries. */
  class Member(_tableTag: Tag) extends Table[MemberRow](_tableTag, "MEMBER") {
    def * = (memberId, memberName, email, password, role, insTime, updTime) <> (MemberRow.tupled, MemberRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (memberId.?, memberName.?, email.?, password.?, role.?, insTime.?, updTime.?).shaped.<>({r=>import r._; _1.map(_=> MemberRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column MEMBER_ID DBType(BIGINT), AutoInc, PrimaryKey */
    val memberId: Column[Long] = column[Long]("MEMBER_ID", O.AutoInc, O.PrimaryKey)
    /** Database column MEMBER_NAME DBType(VARCHAR), Length(20,true) */
    val memberName: Column[String] = column[String]("MEMBER_NAME", O.Length(20,varying=true))
    /** Database column EMAIL DBType(VARCHAR), Length(100,true) */
    val email: Column[String] = column[String]("EMAIL", O.Length(100,varying=true))
    /** Database column PASSWORD DBType(VARCHAR), Length(255,true) */
    val password: Column[String] = column[String]("PASSWORD", O.Length(255,varying=true))
    /** Database column ROLE DBType(VARCHAR), Length(5,true) */
    val role: Column[String] = column[String]("ROLE", O.Length(5,varying=true))
    /** Database column INS_TIME DBType(TIMESTAMP) */
    val insTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("INS_TIME")
    /** Database column UPD_TIME DBType(TIMESTAMP) */
    val updTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("UPD_TIME")
    
    /** Uniqueness Index over (email) (database name EMAIL) */
    val index1 = index("EMAIL", email, unique=true)
    /** Uniqueness Index over (memberName) (database name MEMBER_NAME) */
    val index2 = index("MEMBER_NAME", memberName, unique=true)
  }
  /** Collection-like TableQuery object for table Member */
  lazy val Member = new TableQuery(tag => new Member(tag))
  
  /** Entity class storing rows of table Rental
   *  @param rentalId Database column RENTAL_ID DBType(BIGINT), AutoInc, PrimaryKey
   *  @param memberId Database column MEMBER_ID DBType(BIGINT)
   *  @param libraryId Database column LIBRARY_ID DBType(BIGINT)
   *  @param insTime Database column INS_TIME DBType(TIMESTAMP)
   *  @param updTime Database column UPD_TIME DBType(TIMESTAMP)
   *  @param insUserEmail Database column INS_USER_EMAIL DBType(VARCHAR), Length(100,true)
   *  @param updUserEmail Database column UPD_USER_EMAIL DBType(VARCHAR), Length(100,true) */
  case class RentalRow(rentalId: Long, memberId: Long, libraryId: Long, insTime: java.sql.Timestamp, updTime: java.sql.Timestamp, insUserEmail: String, updUserEmail: String)
  /** GetResult implicit for fetching RentalRow objects using plain SQL queries */
  implicit def GetResultRentalRow(implicit e0: GR[Long], e1: GR[java.sql.Timestamp], e2: GR[String]): GR[RentalRow] = GR{
    prs => import prs._
    RentalRow.tupled((<<[Long], <<[Long], <<[Long], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[String]))
  }
  /** Table description of table RENTAL. Objects of this class serve as prototypes for rows in queries. */
  class Rental(_tableTag: Tag) extends Table[RentalRow](_tableTag, "RENTAL") {
    def * = (rentalId, memberId, libraryId, insTime, updTime, insUserEmail, updUserEmail) <> (RentalRow.tupled, RentalRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (rentalId.?, memberId.?, libraryId.?, insTime.?, updTime.?, insUserEmail.?, updUserEmail.?).shaped.<>({r=>import r._; _1.map(_=> RentalRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column RENTAL_ID DBType(BIGINT), AutoInc, PrimaryKey */
    val rentalId: Column[Long] = column[Long]("RENTAL_ID", O.AutoInc, O.PrimaryKey)
    /** Database column MEMBER_ID DBType(BIGINT) */
    val memberId: Column[Long] = column[Long]("MEMBER_ID")
    /** Database column LIBRARY_ID DBType(BIGINT) */
    val libraryId: Column[Long] = column[Long]("LIBRARY_ID")
    /** Database column INS_TIME DBType(TIMESTAMP) */
    val insTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("INS_TIME")
    /** Database column UPD_TIME DBType(TIMESTAMP) */
    val updTime: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("UPD_TIME")
    /** Database column INS_USER_EMAIL DBType(VARCHAR), Length(100,true) */
    val insUserEmail: Column[String] = column[String]("INS_USER_EMAIL", O.Length(100,varying=true))
    /** Database column UPD_USER_EMAIL DBType(VARCHAR), Length(100,true) */
    val updUserEmail: Column[String] = column[String]("UPD_USER_EMAIL", O.Length(100,varying=true))
    
    /** Foreign key referencing Library (database name rental_ibfk_2) */
    lazy val libraryFk = foreignKey("rental_ibfk_2", libraryId, Library)(r => r.libraryId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Member (database name rental_ibfk_1) */
    lazy val memberFk = foreignKey("rental_ibfk_1", memberId, Member)(r => r.memberId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Rental */
  lazy val Rental = new TableQuery(tag => new Rental(tag))
}